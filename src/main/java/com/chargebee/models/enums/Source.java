package com.chargebee.models.enums;

public enum Source {
    ADMIN_CONSOLE,
    API,
    SCHEDULED_JOB,
    HOSTED_PAGE,
    PORTAL,
    SYSTEM,
    NONE,
    JS_API,
    MIGRATION,
    BULK_OPERATION,
    EXTERNAL_SERVICE,
    _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
    java-client version incompatibility. We suggest you to upgrade to the latest version */
}