require oasis-ament-cmake.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_perception_cpp"

DEPENDS:append = " \
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
    sensor-msgs \
    std-msgs \
"

# Disable 'dev-elf' QA for the -dev package (unversioned .so symlink rule)
INSANE_SKIP:${PN}-dev += "dev-elf"
