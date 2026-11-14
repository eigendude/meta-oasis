require oasis-ament-python.inc
require oasis-systemd.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_drivers_py"

OASIS_SYSTEMD_SERVICE = "oasis_drivers.service"

RDEPENDS:${PN}:append = " \
    builtin-interfaces \
    geometry-msgs \
    oasis-drivers-cpp \
    oasis-home \
    oasis-msgs \
    python3-psutil \
    python3-pyserial \
    python3-telemetrix-aio \
    rclcpp-components \
    rclpy \
    sensor-msgs \
    std-msgs \
    util-linux-chrt \
    v4l2-camera \
"

do_install:append() {
    # ros_ament_python rewrites scripts in lib/${ROS_BPN} with a Python shebang.
    # Both upstream units execute this Bash helper directly.
    install -d "${D}${ros_libdir}/${ROS_BPN}"
    install -m 0755 "${S}/scripts/delay_launch.sh" \
        "${D}${ros_libdir}/${ROS_BPN}/delay_launch.sh"

    # Install shell profiles
    install -d "${D}${sysconfdir}/profile.d"
    echo "source /opt/ros/${ROS2_DISTRO}/setup.bash" > "${D}${sysconfdir}/profile.d/oasis_profile.sh"
    echo "export ROS_LOG_DIR=/data/log/oasis" >> "${D}${sysconfdir}/profile.d/oasis_profile.sh"
}
