# OpenMP pulls in clang by default
PACKAGECONFIG:remove = "openmp"

# Disable building tests
PACKAGECONFIG:remove = "tests"
