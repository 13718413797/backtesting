package com.kunyandata.backtesting.filter.common

import java.util.concurrent.{Callable, FutureTask}

import com.kunyandata.backtesting.filter.Filter
import com.kunyandata.backtesting.io.RedisHandler
import com.kunyandata.backtesting.util.CommonUtil

import scala.collection.mutable

/**
  * Created by YangShuai
  * Created on 2016/9/1.
  */
class AllDayValueFilter private(prefix: String, min: Int, max: Int, start: Int, end: Int) extends Filter {

  override def filter(): List[String] = {

    val resultSet = mutable.Set[String]()

    for (i <- start to end) {

      val key = prefix + CommonUtil.getDateStr(i)
      val jedis = RedisHandler.getInstance().getJedis
      val result = jedis.zrangeByScore(key, min, max)

      if (i == start) {

        val iterator = result.iterator()

        while (iterator.hasNext) {
          val code = iterator.next()
          resultSet.add(code)
        }

      } else {

        val iterator = resultSet.iterator

        while (iterator.hasNext) {

          val code = iterator.next()

          if (!result.contains(code))
            resultSet.remove(code)

        }

      }

    }

    resultSet.toList
  }
}

object AllDayValueFilter {

  def apply(prefix: String, min: Int, max: Int, start: Int, end: Int): ContiValueFilter = {

    val filter = new ContiValueFilter(prefix, min, max, start, end)

    filter.futureTask = new FutureTask[List[String]](new Callable[List[String]] {
      override def call(): List[String] = filter.filter()
    })

    filter
  }

}
