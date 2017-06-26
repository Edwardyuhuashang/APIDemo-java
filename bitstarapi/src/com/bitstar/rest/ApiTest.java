package com.bitstar.rest;

import com.bitstar.rest.feature.IAPIService;
import com.bitstar.rest.impl.APIServiceImpl;

public class ApiTest {
	
	public static void main(String[] args) throws Exception{
		
		String rootUrl = "https://www.bitstar.com";
		String accessKey = "";
		String secretKey = "";
		
		IAPIService service = new APIServiceImpl(accessKey,secretKey,rootUrl);
		
		//Ticker信息
		String tickerInfo = service.getTicker("swap-btc-cny");
		System.out.println(tickerInfo);
		
		//深度信息
		String depthInfo = service.getDepth("swap-btc-cny", "20");
		System.out.println(depthInfo);
		
		//最新成交记录
		String tradeInfo = service.getTrades("swap-btc-cny");
		System.out.println(tradeInfo);
		
		//K线信息
		String klineInfo = service.getkline("swap-btc-cny", "1min", "100");
		System.out.println(klineInfo);
		
		//其他公共信息
		String publicInfo = service.publicInfo("swap-btc-cny");
		System.out.println(publicInfo);
		
		//用户主资产信息
		String mainAccount = service.mainAccount("btc");
		System.out.println(mainAccount);
		
		//用户子账号信息（合约资产）
		String subAccount = service.subAccount("swap-btc");
		System.out.println(subAccount);
		
		//主资产向子账号转入
		String transferToSub = service.transferToSub("swap-btc", "1");
		System.out.println(transferToSub);
		
		//子账号向主资产转出
		String transferToMain = service.transferToMain("swap-btc", "1");
		System.out.println(transferToMain);
		
		//下单
		String placeOrder = service.placeOrder("swap-btc-cny", "1", "20000", "20000");
		System.out.println(placeOrder);
		
		//撤销订单
		String cancel = service.cancel("swap-btc-cny", "100021");
		System.out.println(cancel);
		
		//查看单个订单信息
		String orderInfo = service.orderinfo("swap-btc-cny", "100021");
		System.out.println(orderInfo);
		
		//查看委托中订单信息
		String order_in = service.orders_in("swap-btc-cny");
		System.out.println(order_in);
		
		//查看最近完成订单信息
		String orders_over = service.orders_over("swap-btc-cny");
		System.out.println(orders_over);
		
		//查看持仓信息
		String storyInfo = service.storeinfo("swap-btc-cny");
		System.out.println(storyInfo);
		
	}
}
