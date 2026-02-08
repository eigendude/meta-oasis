require oasis.inc

inherit ros_component
inherit ros_distro_${ROS_DISTRO}

S:scarthgap = "${WORKDIR}/git"
S:append = "/${ROS_BPN}"
