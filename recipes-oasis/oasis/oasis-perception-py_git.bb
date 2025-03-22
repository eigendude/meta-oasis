require oasis-ament-python.inc

ROS_CN = "oasis"
ROS_BPN = "oasis_perception_py"

inherit systemd

do_install:append() {
    # Install systemd services
    install -d "${D}${systemd_system_unitdir}"
    install -m 0644 "${S}/config/systemd/"*.service "${D}${systemd_system_unitdir}"
}

# Systemd services
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = " \
    oasis_perception.service \
"

# Installed package files
FILES:${PN} = " \
    ${systemd_system_unitdir} \
"

# Installed Python files
FILES:${PN}:append = " \
    /opt/ros/${ROS2_DISTRO} \
"
