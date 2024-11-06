FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://0001-Allow-UPD-on-private-networks-in-ufw-firewall.patch \
"
