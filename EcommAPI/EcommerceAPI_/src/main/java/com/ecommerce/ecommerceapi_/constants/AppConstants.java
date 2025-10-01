package com.ecommerce.ecommerceapi_.constants;

public interface AppConstants {
    String APP_NAME = "EcommerceAPI";

    String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    int DEFAULT_PAGE_NUMBER = 0;
    String DEFAULT_PAGE_SIZE = "20";
    String DEFAULT_SORT_BY = "createdAt";
    String DEFAULT_SORT_DIRECTION = "DESC";

    String DEFAULT_CURRENCY = "USD";
    String DEFAULT_LOCALE = "en_US";
    String DEFAULT_COUNTRY = "US";
    String DEFAULT_CURRENCY_CODE = "USD";

    String HEADER_REQUEST_ID = "X-Request-ID";
    String HEADER_USER_AGENT = "User-Agent";
    String HEADER_ACCEPT = "Accept";

    String HEADER_CONTENT_TYPE = "Content-Type";
    String HEADER_CONTENT_LENGTH = "Content-Length";
    String HEADER_CONTENT_ENCODING = "Content-Encoding";

    String HEADER_DATE = "Date";
    String HEADER_EXPIRES = "Expires";
    String HEADER_LOCATION = "Location";

    String HEADER_WWW_AUTHENTICATE = "WWW-Authenticate";


    // file uploads
    long MAX_FILE_SIZE = 5 * 1024 * 1024;
    String[] ALLOWED_FILE_TYPES = {"image/jpeg", "image/png"};


    // Cache Keys
    String CACHE_PRODUCTS = "CACHE_PRODUCTS";
    String CACHE_USERS = "CACHE_USERS";
    String CACHE_ORDERS = "CACHE_ORDERS";


    // Messaging / Queues
    public static final String QUEUE_ORDER_EVENTS = "order.events";
    public static final String QUEUE_PAYMENT_EVENTS = "payment.events";
    public static final String TOPIC_NOTIFICATIONS = "topic.notifications";

    // Payment
    String PAYMENT_PENDING = "PAYMENT_PENDING";
    String PAYMENT_SUCCESS = "PAYMENT_SUCCESS";
    String PAYMENT_FAILED = "PAYMENT_FAILED";

}
