cmake_minimum_required(VERSION 3.4.1)



include_directories(../libcommon)
include_directories(../libcommon/egl_core)
include_directories(../libcommon/message_queue)
include_directories(../libcommon/opensl_media)
include_directories(../libcommon/opengl_media)
include_directories(../libcommon/opengl_media/render)
include_directories(../libcommon/opengl_media/texture)
include_directories(../libcommon/opengl_media/texture_copier)
add_library(
        encoder-lib

        STATIC
		soft_encoder/color_conversion/color_conversion_armv7a.cpp
        video_encoder_adapter.cpp
        live_video_packet_queue.cpp
		soft_encoder/soft_encoder_adapter.cpp
		soft_encoder/host_gpu_copier.cpp
		soft_encoder/yuy2_video_frame_pool.cpp
		soft_encoder/video_x264_encoder.cpp
		hw_encoder/hw_encoder_adapter.cpp)



find_library(
        log-lib
        log )



target_link_libraries(
        encoder-lib
        common-lib
        ${log-lib} )