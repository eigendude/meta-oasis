LICENSE = "BSD-2-Clause"

# apriltag/3.4.3-2/recipe-sysroot-native/usr/lib/python3.12/site-packages/numpy/core/include/numpy/__multiarray_api.h:646:11: error: ISO C forbids conversion of object pointer to function pointer type [-Werror=pedantic]
OECMAKE_C_FLAGS:append = " -Wno-error=pedantic"
