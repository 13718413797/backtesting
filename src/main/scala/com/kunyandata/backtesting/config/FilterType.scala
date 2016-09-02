package com.kunyandata.backtesting.config

/**
  * Created by YangShuai
  * Created on 2016/8/24.
  */
object FilterType extends Enumeration {

  val TotalEquity= Value(101, "total_equity") // 总股本
  val FloatEquity=Value(102, "float_equity") // 流通股本
  val MarketValue = Value(103, "market_value") // 总市值
  val LiquidMarketValue= Value(104, "liquid_market_value") // 流通市值
  val LiquidScale = Value(105, "liquid_scale") // 流通比例
  val TopStockRatio = Value(106, "top_stock_ratio")// 十大股东持股比例
  val HolderCount= Value(107, "holder_count") // 股东户数
  val FloatStockNum = Value(108, "float_stock_num") // 户均持股数
  val InstitutionStockNum = Value(109,"institution_stock_num") // 机构持股
  val AbsoluteChangePercent = Value(201, "absolute_change_percent_") // 涨跌幅（绝对值）
  val IncChangePercent = Value(202, "inc_change_percent_") // 涨幅
  val DecChangePercent = Value(203, "dec_change_percent_") // 跌幅
  val Amplitude =Value(204, "amplitude_") // 振幅
  val TurnoverRation = Value(205, "turnoverratio_") // 换手率
  val Volume = Value(206, "volume_") // 成交量
  val Turnover = Value(207, "turnover_") // 成交额
  val SharePrice = Value(208, "share_price_") // 股价
  val ChangePercent = Value(209, "change_percent_") // 涨跌幅，收益率

  // 股票相关新闻访问量和股票相关新闻转载量
  val Visit = Value(401, "visit_") // 股票相关新闻的日访问量
  val Exposure = Value(402, "exposure_") // 股票相关新闻的日转载量
  val VisitWeek = Value(2401, "visitWeek_") // 股票相关新闻的周访问量
  val ExposureWeek = Value(2402, "exposureWeek_") // 股票相关新闻的周转载量
  val VisitMonth = Value(4401, "visitMonth_") // 股票相关新闻的月访问量
  val ExposureMonth = Value(4402, "exposureMonth_") // 股票相关新闻的月转载量

  // 新闻访问量趋势
  val TrendRise = Value(10001, "trend_") // 股票相关新闻访问量趋势的增长
  val TrendDown = Value(10002, "trend_") // 股票相关新闻访问量趋势的下跌

  // 新闻情感
  val SentimentPos = Value(10003, "sentiment_") // 股票相关新闻非负面情绪
  val SentimentNeg = Value(10004, "sentiment_") // 股票相关新闻负面情绪

  // 大V看好看空
  val VipStockRise = Value(15001, "vipstockstatistic_rise_") // 大V看好
  val VipStockDown = Value(15002, "vipstockstatistic_down_") // 大V看空

  val ChangeInHolding = Value(40001,"change_in_holding") // 增减持

  // 事件
  val Events = Value(40003, "events_") // 事件相关股票

  // 公告性事件
  val AnnouncementProfit = Value(50001, "announcement_profit_") // 公告赢利预增（现在没有赢利预增的具体数值，只有次数）
  val AnnouncementLawsuit = Value(50002, "announcement_lawsuit_") // 公告诉讼仲裁
  val AnnouncementIllegal = Value(50003, "announcement_illegal_") // 公告违规处罚

}
