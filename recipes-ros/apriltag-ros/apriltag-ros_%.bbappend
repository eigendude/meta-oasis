do_configure:append() {
    # tf2/convert.h is intentionally obsolete and triggers a warning (fatal under -Werror)
    sed -i \
      -e 's#<tf2/convert.h>#<tf2/convert.hpp>#g' \
      ${S}/src/pose_estimation.cpp \
      ${S}/src/conversion.cpp
}
