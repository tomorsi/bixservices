from xml.etree import ElementTree

class XMLParser:
    """
    The XML parser that parse the data files for
    testing the RESTFUL APIs
    """
    
    def __init__(self, file, element):
        self.root = ElementTree.parse(file)
        self.element = element

    def start(self):
        self.iterator = self.root.iter(self.element)

    def nextItem(self):
        str = None
        try:
            item = self.iterator.next()
            str = ElementTree.tostring(item)
        except StopIteration:
            pass
        
        return str
    


    
