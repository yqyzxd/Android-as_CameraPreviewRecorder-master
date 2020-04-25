cmake_minimum_required(VERSION 3.4.1)

set(PATH_TO_NATIVE ${CMAKE_SOURCE_DIR})
set(PATH_TO_THIRDPARTY ${PATH_TO_NATIVE}/3rdparty)
set(PATH_TO_PRE_BUILT ${PATH_TO_THIRDPARTY}/prebuilt/${ANDROID_ABI})
include_directories(BEFORE ${PATH_TO_THIRDPARTY}/ffmpeg/include/)
include_directories(camera_preview)
include_directories(libcommon)
include_directories(libcommon/egl_core)
include_directories(libcommon/message_queue)
include_directories(libcommon/opensl_media)
include_directories(libcommon/opengl_media)
include_directories(libcommon/opengl_media/render)
include_directories(libcommon/opengl_media/texture)
include_directories(libcommon/opengl_media/texture_copier)


add_subdirectory(camera_preview)
add_subdirectory(libcommon)
add_subdirectory(video_encoder)

add_library(
        native_encoder-lib

        SHARED

        ChangbaRecordingPreviewScheduler.cpp
)



find_library(
        log-lib

        log )



target_link_libraries(
        native_encoder-lib

        GLESv2
        EGL
        android
        z
        preview-lib
        common-lib
        encoder-lib

          # 引入ffmpeg相关静态库
           ${PATH_TO_PRE_BUILT}/libavfilter.a
           ${PATH_TO_PRE_BUILT}/libavformat.a
           ${PATH_TO_PRE_BUILT}/libavcodec.a
           ${PATH_TO_PRE_BUILT}/libpostproc.a
           ${PATH_TO_PRE_BUILT}/libswresample.a
           ${PATH_TO_PRE_BUILT}/libswscale.a
           ${PATH_TO_PRE_BUILT}/libavutil.a
           ${PATH_TO_PRE_BUILT}/libpostproc.a
           ${PATH_TO_PRE_BUILT}/libfdk-aac.a
           ${PATH_TO_PRE_BUILT}/libvo-aacenc.a
           ${PATH_TO_PRE_BUILT}/libx264.a


        ${log-lib} )