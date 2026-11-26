# DDS firewall access

DDS access is off after flashing. Run `dds_enable.sh` as root to allow incoming
DDS domain 0 traffic immediately. Run `dds_disable.sh` to close the exceptions
on every interface. Both commands take no arguments and can be repeated.

Enabling DDS trusts other hosts on **every directly connected RFC 1918 IPv4
network**, including private VPNs and guest Wi-Fi. The firewall admits UDP
destination ports 7400–7649 from each connected prefix only on the interface
that owns it. Prefixes that extend outside RFC 1918 are skipped, as are
interface names containing control characters or ending in the iptables
wildcard `+`. Any application can use the open ports. DDS peers must provide
their own authentication. Disabling removes the exceptions for new traffic.
UFW's normal handling of established connections still applies.

The only persistent DDS setting is the root-owned marker
`/data/oasis/dds-enabled`. It survives reboot and Mender rootfs replacement
when the data partition is retained. The helpers require mounted, root-owned
state directories that only root can write. If the marker is absent or unsafe
to read, reconciliation clears the DDS chain.

UFW loads an IPv4 jump to the private `oasis-dds` chain immediately before
its user input rules. The UFW start hook, the boot oneshot and kernel link and
IPv4 address notifications reconcile this chain under the same lock. UFW
reloads and service restarts rebuild it from the marker and current addresses.
The rootfs stays read-only. The helpers never write UFW user rules.

Run these commands as root to inspect the port restriction and active
interface/source pairs.

```sh
iptables -S ufw-before-input | grep oasis-dds
iptables -S oasis-dds
```
