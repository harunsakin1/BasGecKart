package com.haruns.basgeckart.constants;

import java.util.EnumSet;

public class RestApis {
	private static final String VERSION = "/v2";
	private static final String API = "/api";
	private static final String DEVELOPER = "/dev";
	private static final String TEST = "/test";
	private static final String PROD = "/prod";
	
	private static final String ROOT = VERSION + DEVELOPER;
	
	public static final String CARD = ROOT +"/card";
	public static final String EXPENSE = ROOT +"/expense";
	public static final String PASSENGER = ROOT +"/passenger";
	public static final String RECHARGE = ROOT +"/recharge";
	public static final String TRANSPORT = ROOT +"/transport";
	
	public static final String ADD_ALL_CARDS ="/add-all-cards";
	public static final String CREATE_ANONYMOUS_CARD ="/create-anonymous-card";
	public static final String CREATE_SPECIAL_CARD = "/create-special-card";
	public static final String USE_CARD = "/use-card";
	public static final String ADD_ALL_PASSENGERS ="/add-all-passengers";
	public static final String SET_CARD_TO_PASSENGER ="/set-card-to-passenger";
	public static final String REGISTER ="/register";
	public static final String FIND_ALL_PASSENGERS ="/find-all-passengers";
	public static final String ADD_RECHARGE ="/add-recharge";
	public static final String ADD_BALANCE ="/add-balance";
	public static final String ADD_ALL_TRANSPORTS ="/add-all-transports";
	public static final String FIND_BY_TC ="/find-by-tc";
	public static final String EXIST_BY_TC ="/exist-by-tc";
	public static final String FIND_BY_ID ="/find-by-id";
	public static final String UPDATE ="/update";
	
	
	
	
	
}