/*
 * NumberUtil.c
 *
 *  Created on: 2016年4月23日
 *      Author: User
 */

#include "NumberUtil.h"

const char* TAG = "NumberUtil";

JNIEXPORT jint JNICALL Java_com_example_hellojni_util_NumberUtil_add
  (JNIEnv *env, jobject obj, jint a, jint b)
{
	return a + b;
}

JNIEXPORT jintArray JNICALL Java_com_example_hellojni_util_NumberUtil_getNumbers
  (JNIEnv *env, jobject obj, jint count)
{
	jint arr[count];
	for (int i = 0; i < count; i++)
	{
		arr[i] = rand() % 10;

		__android_log_print(ANDROID_LOG_DEBUG, TAG, "arr[i]: %d", arr[i]);
	}

	jintArray javaArray = env->NewIntArray(count);
	env->SetIntArrayRegion(javaArray, 0, count, arr);

	return javaArray;
}
