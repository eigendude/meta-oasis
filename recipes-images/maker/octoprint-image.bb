# OASIS image for 3d printing

require recipes-images/oasis/systemd-image.bb

IMAGE_INSTALL += " \
        octoprint-nginx \
        screen \
        bash \
        sshfs-fuse \
	rsync \
	avrdude \
	uvc-ctrl \
"

export IMAGE_BASENAME = "Octoprint-image"

