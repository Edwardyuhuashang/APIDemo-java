package com.bitstar.rest.feature;

public interface IAPIService {

	/**
	 * Ticker信息,api/v1/market/ticker/{businessType} （GET）
	 * @param businessType  (swap-btc-cny 比特币对人民币现货合约)
	 * @return
	 * @throws Exception
	 */
	String getTicker(String businessType) throws Exception;

	/**
	 * 深度信息,api/v1/market/depth/{businessType}?size={size} （GET）
	 * @param businessType  (swap-btc-cny 比特币对人民币现货合约)
	 * @param size  需要获取的深度数量，非必填，默认买卖盘各50条
	 * @return
	 * @throws Exception
	 */
	String getDepth(String businessType,String size) throws Exception;

	/**
	 * 最新成交记录,api/v1/market/trades/{businessType} （GET）
	 * @param businessType  (swap-btc-cny 比特币对人民币现货合约)
	 * @return
	 * @throws Exception
	 */
	String getTrades(String businessType) throws Exception;

	/**
	 * K线信息,api/v1/market/kline/{businessType}/{ktype}?size={size} （GET）
	 * @param businessType  (swap-btc-cny 比特币对人民币现货合约)
	 * @param ktype  K线类型(1min：一分钟K线 ，5min：五分钟K线 ，15min：十五分钟K线 ，30min：三十分钟K线 ，1hour：一小时K线 ，2hour：二小时K线 ，4hour：四小时K线 ，12hour：十二小时K线 ，1day：每日K线，1week：每周K线，1month：每月K线)
	 * @param size	需要获取的深度数量，非必填，默认300
	 * @return
	 * @throws Exception
	 */
	String getkline(String businessType, String ktype, String size) throws Exception;

	/**
	 * 其他公共信息,api/v1/market/publicInfo/{businessType} （GET）
	 * @param businessType  (swap-btc-cny 比特币对人民币现货合约)
	 * @return
	 * @throws Exception
	 */
	String publicInfo(String businessType) throws Exception;

	/**
	 * 用户主资产信息,api/v1/fund/mainAccount/{currency} （POST）
	 * @param currency (btc  比特币, eth  以太坊)
	 * @return
	 * @throws Exception
	 */
	String mainAccount(String currency) throws Exception;

	/**
	 * 用户子账号信息（合约资产）,/api/v1/fund/subAccount/{contractCode} （POST）
	 * @param contractCode (swap-btc 　比特币现货合约, swap-eth 　以太坊现货合约)
	 * @return
	 * @throws Exception
	 */
	String subAccount(String contractCode) throws Exception;

	/**
	 * 主资产向子账号转入,api/v1/fund/transferToSub/{contractCode}/{amount} （POST）
	 * @param contractCode (swap-btc 比特币现货合约, swap-eth 以太坊现货合约)
	 * @param amount 转入数量
	 * @return
	 * @throws Exception
	 */
	String transferToSub(String contractCode,String amount) throws Exception;

	/**
	 * 子账号向主资产转出,api/v1/fund/transferToMain/{contractCode}/{amount}（POST）
	 * @param contractCode (swap-btc 比特币现货合约, swap-eth 以太坊现货合约)
	 * @param amount 转入数量
	 * @return
	 * @throws Exception
	 */
	String transferToMain(String contractCode,String amount) throws Exception;

	/**
	 * 下单,api/v1/trade/order/{businessType}/{tradeType}/{price}/{amount}（POST）
	 * @param businessType  (swap-btc-cny 比特币对人民币现货合约)
	 * @param tradeType 　1 开多 　2 开空　 3 平多　 4 平空
	 * @param price		买入卖出价格
	 * @param amount	买入卖出数量（数字货币数量商品数量=下单价*数字货币数量）
	 * @return
	 * @throws Exception
	 */
	String placeOrder(String businessType,String tradeType,String price,String amount) throws Exception;

	/**
	 * 撤销订单,api/v1/trade/cancel/{businessType}/{orderid}（POST）
	 * @param businessType  (swap-btc-cny 比特币对人民币现货合约)
	 * @param orderid	订单ID
	 * @return
	 * @throws Exception
	 */
	String cancel(String businessType,String orderid) throws Exception;

	/**
	 * 查看单个订单信息,api/v1/trade/orderinfo/{businessType}/{orderid}（POST）
	 * @param businessType	(swap-btc-cny 比特币对人民币现货合约)
	 * @param orderid	订单ID
	 * @return
	 * @throws Exception
	 */
	String orderinfo(String businessType,String orderid) throws Exception;

	/**
	 * 查看委托中订单信息,api/v1/trade/orders_in/{businessType}/{tradeType}（POST）
	 * @param businessType	(swap-btc-cny 比特币对人民币现货合约)
	 * @return
	 * @throws Exception
	 */
	String orders_in(String businessType) throws Exception;

	/**
	 * 查看最近完成订单信息,api/v1/trade/orders_over/{businessType}（POST）
	 * @param businessType	(swap-btc-cny 比特币对人民币现货合约)
	 * @return
	 * @throws Exception
	 */
	String orders_over(String businessType) throws Exception;

	/**
	 * 查看持仓信息,api/v1/trade/storeinfo/{businessType}（POST）
	 * @param businessType	(swap-btc-cny 比特币对人民币现货合约)
	 * @return
	 * @throws Exception
	 */
	String storeinfo(String businessType) throws Exception;

}
