from httplib import HTTPConnection


class Requestor:
    """
    The HTTP requestor class for testing RESTFUL APIs
    """
    
    def __init__(self, host, url, headers):
        self.host = host
        self.url = url
        self.headers = headers

        self.server = HTTPConnection(self.host)


    def put(self, params):

        self.server.request("PUT", self.url, params, self.headers)

        self.response = self.server.getresponse()
        
        return self.response.status

    def get(self):
        
        self.server.request("GET", self.url)

        self.response = self.server.getresponse()

        return self.response.status, self.response


