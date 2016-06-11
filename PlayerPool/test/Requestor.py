
import httplib

class Requestor:
    
    def __init__(self, host, url, headers):
        self.host = host
        self.url = url
        self.headers = headers
        

    def put(self, params):
        self.server = httplib.HTTPConnection(self.host)

        print "sending: " + params
        
        self.server.request("PUT", self.url, params, self.headers)

        self.response = self.server.getresponse()

        return self.response.status

    def get(self):
        self.server = httplib.HTTPConnection(self.host)

        print "http get: " + self.url
        
        self.server.request("GET", self.url)

        self.response = self.server.getresponse()

        print "response: " + repr(self.response)
        
        return self.response.status
        



additem ="<rink>\
    <rinkName>Nazareth Ice Oasis</rinkName>\
    <address>3140 Bay Road, Redwood City</address>\
    <zipCode>94063</zipCode>\
    <stateCode>CA</stateCode>\
    <managerPhone>6503648090</managerPhone>\
    <managerEmail>hanna@iceasis.com</managerEmail>\
    <password>niemi5</password>\
  </rink>"


#requestor = Requestor("localhost:8080",
#                      "/PlayerPoolService/rest/PlayerPoolService/Rinks",
#                      {"Content-Type" : "application/xml"})
#
#response = requestor.put(additem)
#print "response: " + repr(response)


requestor = Requestor("localhost:8080",
                      "/PlayerPoolService/rest/PlayerPoolService/Rinks",
                      {"Content-Type" : "application/xml"})

response = requestor.get()
print "response: " + repr(response)
