#include <jni.h>
#include <string>
#include <android/log.h>

#define LOG(MESSAGE, VALUE) \
 __android_log_print(ANDROID_LOG_VERBOSE, MESSAGE, "%d", VALUE);


extern "C" JNIEXPORT jint JNICALL
Java_com_vectone_firstndk_MainActivity_mul(JNIEnv *env, jobject obj, jint n1, jint n2) {
    LOG("MUL ", n1 * n2);
    return n1 * n2;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_vectone_firstndk_MainActivity_div(JNIEnv *env, jobject obj, jint n1, jint n2) {
    LOG("DIV ", n1 / n2);
    return n1 / n2;
}

extern "C" JNIEXPORT void JNICALL
Java_com_vectone_firstndk_MainActivity_inputFromJava(JNIEnv *env, jobject obj, jstring h) {
    LOG("DIV ", h);
}

