require systemd-image.bb

CONMANPKGS = "networkmanager network-manager-applet"

EXTRA_IMAGE_FEATURES += "splash"

IMAGE_INSTALL += " \
	packagegroup-xfce-base \
	packagegroup-gnome-xserver-base \
	packagegroup-core-x11-xserver \
	packagegroup-gnome-fonts \
	oasis-gdm-autologin-hack oasis-gdm-xfce-hack gdm \
	oasis-gnome-icon-theme-enable gtk-engine-clearlooks gtk-theme-clearlooks oasis-clearlooks-theme-enable \
"

export IMAGE_BASENAME = "XFCE-NetworkManager-image"

