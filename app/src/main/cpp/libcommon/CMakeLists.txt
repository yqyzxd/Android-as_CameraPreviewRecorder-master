cmake_minimum_required(VERSION 3.4.1)


aux_source_directory(. SOURCE)

file(GLOB egl_file egl_core/*.cpp)
file(GLOB queue_file message_queue/*.cpp)
file(GLOB opengl_media_file opengl_media/*.cpp)
file(GLOB opengl_media_render_file opengl_media/render/*.cpp)
file(GLOB opengl_media_texture_file opengl_media/texture/*.cpp)
file(GLOB opengl_media_texture_copier_file opengl_media/texture_copier/*.cpp)
file(GLOB opensl_media_file opensl_media/*.cpp)

include_directories(../camera_preview)

add_library(

        common-lib

        STATIC

       ${egl_file}
       ${queue_file}
       ${opengl_media_file}
       ${opensl_media_file}
       ${opengl_media_render_file}
       ${opengl_media_texture_file}
       ${opengl_media_texture_copier_file}
        ${SOURCE} )



find_library(
        log-lib

        log )



target_link_libraries(

        common-lib


        ${log-lib} )