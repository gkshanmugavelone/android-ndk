#include <jni.h>
#include <string>
#include <android/log.h>

#define JNI_METHOD(RETURN, METHOD_NAME) \
 extern "C" JNIEXPORT RETURN JINICALL Java_com_vectone_firstndk_MainActivity_##METHOD_NAME;

#define LOG(MESSAGE, VALUE) \
 __android_log_print(ANDROID_LOG_VERBOSE, MESSAGE, "%d", VALUE);

extern "C" JNIEXPORT jstring JNICALL Java_com_vectone_firstndk_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL Java_com_vectone_firstndk_MainActivity_add(
        JNIEnv *env,
        jobject, jint x, jint y) {
    LOG("ADD ", x + y);
    return x + y;
}

extern "C" JNIEXPORT jint JNICALL Java_com_vectone_firstndk_MainActivity_sub(
        JNIEnv *env,
        jobject, jint x, jint y) {
    jint sub = x - y;
    LOG("SUB ", sub);
    return sub;
}