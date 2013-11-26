package com.sonos.smapi;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.message.Message;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxws.context.WrappedMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.w3c.dom.Node;

import com.sonos.smapi.soap.Credentials;
import com.sonos.smapi.soap.LoginToken;


public class CredentialsHelper {
	private static Logger logger = LoggerFactory.getLogger(CredentialsHelper.class);
	public static String getCredentialsFromHeaders(WebServiceContext context) {
		MessageContext messageContext = context.getMessageContext();
		if (messageContext == null
		    || !(messageContext instanceof WrappedMessageContext)) {
			logger.error("Not wrapped");
			return null;
		}

		Message message = ((WrappedMessageContext) messageContext)
			.getWrappedMessage();
		List<Header> headers = CastUtils.cast((List<?>) message
						      .get(Header.HEADER_LIST));
		if (headers != null) {
			for (Header h : headers) {
				Object o = h.getObject();
				// Unwrap the node using JAXB
				if (o instanceof Node) {
					JAXBContext jaxbContext;
					try {
						jaxbContext = new JAXBDataBinding(Credentials.class)
							.getContext();
						Unmarshaller unmarshaller = jaxbContext
							.createUnmarshaller();
						o = unmarshaller.unmarshal((Node) o);
					} catch (JAXBException e) {
						// failed to get the credentials object from the headers
					}
				}
				if (o instanceof Credentials) {
					Credentials c = (Credentials) o;
					LoginToken loginToken = c.getLoginToken();
					if (loginToken == null) {
						return null;
					}
					String household = loginToken.getHouseholdId();
					String token = loginToken.getToken();
					String key = loginToken.getKey();

					return token;
				} else {
					logger.error("no Credentials object");
				}
			}
		} else {
			logger.error("No headers found");
		}
		return null;
	}
}
