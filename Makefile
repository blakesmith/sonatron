CONF_DIR=conf
RELEASE_DIR=release
PREFIX=/usr/local
PKG_NAME=sonatron

all: package

clean:
	rm -rf $(RELEASE_DIR)
	rm -rf $(PKG_NAME).deb
	sbt clean

setup:
	mkdir -p $(RELEASE_DIR)
	cp -r $(CONF_DIR)/* $(RELEASE_DIR)/

build:
	sbt one-jar

package: setup build
	cp target/scala-2.10/sonatron_*-one-jar.jar $(RELEASE_DIR)/usr/local/lib/sonatron/sonatron.jar
	dpkg -b $(RELEASE_DIR)/ $(PKG_NAME).deb
