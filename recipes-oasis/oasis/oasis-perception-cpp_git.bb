require oasis-ament-cmake.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_perception_cpp"

DEPENDS:append = " \
    ament-index-cpp \
    apriltag \
    apriltag-msgs \
    bgslibrary \
    cv-bridge \
    geometry-msgs \
    image-transport \
    message-filters \
    oasis-msgs \
    pcl \
    pcl-conversions \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
"

# ROS component/core libraries are real runtime-loaded shared objects, not
# development symlinks. Keep unversioned .so files out of ${PN}-dev.
FILES_SOLIBSDEV = ""

FILES:${PN}:append = " \
    /opt/ros/${ROS2_DISTRO}/lib/*.so \
"
