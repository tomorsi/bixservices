from Requestor import Requestor
from Parser import Parser

"""
The main function for unit testing the RESTFUL APIS for BIX.
- Load up Rink Table
- Load up Skater Table
"""

addSkaters = Requestor("localhost:8080",
                      "/PlayerPoolService/rest/PlayerPoolService/Skater",
                      {"Content-Type" : "application/xml"})

skaterList = Parser("skaters.xml","skater")
skaterList.start()

skater = skaterList.nextItem()

while skater:
    addSkaters.put(skater)
    skater = skaterList.nextItem()
    
addRinks = Requestor("localhost:8080",
                      "/PlayerPoolService/rest/PlayerPoolService/Rink",
                      {"Content-Type" : "application/xml"})

rinkList = Parser("rinks.xml", "rink")

rinkList.start()

rink = rinkList.nextItem()

while rink:
    addRinks.put(rink)
    rink = rinkList.nextItem()
    






