require oasis-ament-cmake.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_drivers_cpp"

DEPENDS:append = " \
    geometry-msgs \
    i2cdevlib \
    libcec \
    libeigen \
    nav-msgs \
    oasis-msgs \
    rclcpp \
    rclcpp-components \
    rcutils \
    sensor-msgs \
    std-msgs \
    tf2-ros \
    udev \
    yaml-cpp \
"

RDEPENDS:${PN}:append = " \
    oasis-msgs \
    rclcpp \
"

# ROS component/core libraries are real runtime-loaded shared objects, not
# development symlinks. Keep unversioned .so files out of ${PN}-dev.
FILES_SOLIBSDEV = ""

FILES:${PN}:append = " \
    /opt/ros/${ROS2_DISTRO}/lib/*.so \
"
