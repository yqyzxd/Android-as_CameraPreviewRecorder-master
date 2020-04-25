cmake_minimum_required(VERSION 3.4.1)


aux_source_directory(. SOURCE)

include_directories(libcommon)
include_directories(libcommon/egl_core)
include_directories(libcommon/message_queue)
include_directories(libcommon/opensl_media)
include_directories(libcommon/opengl_media)
include_directories(libcommon/opengl_media/render)
include_directories(libcommon/opengl_media/texture)
include_directories(libcommon/opengl_media/texture_copier)
add_library(
        preview-lib


        STATIC


        ${SOURCE} )



find_library(
        log-lib


        log )



target_link_libraries(
        preview-lib
        common-lib
        ${log-lib} )