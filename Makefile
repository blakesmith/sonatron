CONF_DIR=conf
RELEASE_DIR=release
PREFIX=/usr/local
PKG_NAME=sonatron

all: package

clean:
	sbt clean

package:
	sbt debian:packageBin

