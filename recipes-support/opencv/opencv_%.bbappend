FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-GAPI-Implement-RGBA2Gray-and-GBRA2Gray.patch \
"

# Enable the DNN module
PACKAGECONFIG:append = " dnn"

# Disable OpenCV sample programs
PACKAGECONFIG:remove = "samples"
