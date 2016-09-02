package com.kunyandata.backtesting.filter.common

import java.util.concurrent.{Callable, FutureTask}

import com.kunyandata.backtesting.filter.Filter
import com.kunyandata.backtesting.io.RedisHandler
import scala.collection.JavaConversions._

/**
  * Created by YangShuai
  * Created on 2016/9/2.
  */
class SingleValueFilter private(prefix: String, min: Int, max: Int) extends Filter {

  override def filter(): List[String] = {

    val key = prefix
    val jedis = RedisHandler.getInstance().getJedis
    val result = jedis.zrangeByScore(key, min, max)

    result.toList
  }

}

object SingleValueFilter {

  def apply(prefix: String, min: Int, max: Int): ContiValueFilter = {

    val filter = new ContiValueFilter(prefix, min, max)

    filter.futureTask = new FutureTask[List[String]](new Callable[List[String]] {
      override def call(): List[String] = filter.filter()
    })

    filter
  }

}
