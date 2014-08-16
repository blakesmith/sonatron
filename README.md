# Sonatron

This is the source that powers [Sonatron](http://sonatron.blakesmith.me). This code allows me to run extra custom streaming services on my home [Sonos](http://sonos.com) device.

Services supported:

- Soundcloud
- DigitallyImported
- Youtube (Experimental, depends on [ytst](http://github.com/blakesmith/ytst)

This code runs a compatible Sonos SOAP service which handles mediating the SONOS device calls, as well as a simple jetty web server to handle authentication flows.
