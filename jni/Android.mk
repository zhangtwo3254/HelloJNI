LOCAL_PATH := $(call my-dir)

# StringUtil
include $(CLEAR_VARS)

LOCAL_MODULE    := StringUtil
LOCAL_SRC_FILES := StringUtil.cpp
LOCAL_LDLIBS += -llog

include $(BUILD_SHARED_LIBRARY)

# NumberUtil
include $(CLEAR_VARS)

LOCAL_MODULE := NumberUtil
LOCAL_SRC_FILES := NumberUtil.cpp
LOCAL_LDLIBS += -llog

include $(BUILD_SHARED_LIBRARY)