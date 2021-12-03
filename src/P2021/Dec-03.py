def fileInput():
    file = open("resources/03-file.txt" , 'r')
    content = file.read()
    li = content.split("\n")
    return li

def findBit(li):
    bits = []
    for i, e in enumerate(li):
        line = []
        line[:] = e
        
        if i>10:
            print(bits)
            break



def main():
    source = fileInput()
    findBit(source)

main()