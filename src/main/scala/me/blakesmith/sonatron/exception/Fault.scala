package me.blakesmith.sonatron.exception

import javax.xml.namespace.QName
import javax.xml.soap.SOAPFactory
import javax.xml.ws.soap.SOAPFaultException


object Fault {
  val factory = SOAPFactory.newInstance

  def sonosFault(message: String, faultCode: String, sonosErrorCode: Int) = {
    val fault = factory.createFault(message, new QName(faultCode))
    val faultDetail = fault.addDetail
    val sonosError = faultDetail.addDetailEntry(new QName("SonosError"))
    val exceptionInfo = faultDetail.addDetailEntry(new QName("ExceptionInfo"))
    sonosError.addTextNode(sonosErrorCode.toString)
    exceptionInfo.addTextNode(faultCode)
    throw new SOAPFaultException(fault)
  }
}
