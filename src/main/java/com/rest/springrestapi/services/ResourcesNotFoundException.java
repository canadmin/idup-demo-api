package com.rest.springrestapi.services;

public class ResourcesNotFoundException extends RuntimeException {
    public ResourcesNotFoundException() {
    }

    public ResourcesNotFoundException(String message) {
        super(message);
    }

    public ResourcesNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public ResourcesNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    protected ResourcesNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
