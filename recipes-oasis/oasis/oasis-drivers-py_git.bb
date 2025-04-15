require oasis-ament-python.inc

SRC_URI:append = " \
    file://oasis_drivers.service \
"

ROS_CN = "oasis"
ROS_BPN = "oasis_drivers_py"

inherit systemd

RDEPENDS:${PN}:append = " \
    builtin-interfaces \
    geometry-msgs \
    oasis-msgs \
    python3-psutil \
    python3-pyserial \
    sensor-msgs \
    std-msgs \
    v4l2-camera \
"

do_install:append() {
    # Install systemd services
    install -d "${D}${systemd_system_unitdir}"
    install -m 0644 "${WORKDIR}/oasis_drivers.service" "${D}${systemd_system_unitdir}"

    # Install shell profiles
    install -d "${D}${sysconfdir}/profile.d"
    echo "source /opt/ros/${ROS2_DISTRO}/setup.bash" > "${D}${sysconfdir}/profile.d/oasis_profile.sh"
}

# Systemd services
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = " \
    oasis_drivers.service \
"

# Installed package files
FILES:${PN} = " \
    ${sysconfdir}/profile.d \
    ${systemd_system_unitdir} \
"

# Installed Python files
FILES:${PN}:append = " \
    /opt/ros/${ROS2_DISTRO} \
"
