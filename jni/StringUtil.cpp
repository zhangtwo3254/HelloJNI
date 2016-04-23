/*
 * StringUtil.cpp
 *
 *  Created on: 2016年4月23日
 *      Author: User
 */

#include "StringUtil.h"

const char* TAG = "StringUtil";

JNIEXPORT void JNICALL Java_com_example_hellojni_util_StringUtil_init
  (JNIEnv *env, jobject obj)
{
	jclass cls = env->GetObjectClass(obj);
	jfieldID sField = env->GetFieldID(cls, "s", "Ljava/lang/String;");
	jstring s = env->NewStringUTF("string from jni");
	env->SetObjectField(obj, sField, s);
}

JNIEXPORT jstring JNICALL Java_com_example_hellojni_util_StringUtil_getString(
		JNIEnv *env, jclass obj) {
	return env->NewStringUTF("Hello from jni!");
}

JNIEXPORT jstring JNICALL Java_com_example_hellojni_util_StringUtil_getString__Ljava_lang_String_2(
		JNIEnv *env, jclass obj, jstring javaString) {
	const char *str;
	jboolean isCopy;

	str = env->GetStringUTFChars(javaString, &isCopy);

	if (0 != str) {
		__android_log_print(ANDROID_LOG_INFO, TAG, "Java string: ");

		if (JNI_TRUE == isCopy) {
			__android_log_print(ANDROID_LOG_INFO, TAG, "C string is a copy of the Java string.");
		} else {
			__android_log_print(ANDROID_LOG_INFO, TAG, "C string points to actual string.");
		}
	}

	env->ReleaseStringUTFChars(javaString, str);

	return env->NewStringUTF("Hello 2 from jni c!");
}
