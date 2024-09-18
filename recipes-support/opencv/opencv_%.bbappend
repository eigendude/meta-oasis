# Enable the DNN module
PACKAGECONFIG:append = " dnn"

# Disable OpenCV sample programs
PACKAGECONFIG:remove = "samples"
