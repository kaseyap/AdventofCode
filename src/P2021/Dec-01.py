def fileInput():
    file = open("resources/01-file.txt" , 'r')
    content = file.read()
    li = content.split("\n")
    return li

def iterate(li):
    count =0
    for i, e in enumerate(li):
        if i>0:
            if int(e)>int(li[i-1]):
                count = count+1
def iterate2(li):
    count = 0
    previousNum = 0
    for i, e in enumerate(li):
        try:
            num1 = int(e)
            num2 = int(li[i+1])
            num3 = int(li[i+2])
            if i==0:
                previousNum = num1+num2+num3
            else:
                tot = num1+num2+num3
                if tot>previousNum:
                    count = count+1
                previousNum = tot
        except:
            return count
                     
def main():
    listOfNumbers = fileInput()
    total = iterate2(listOfNumbers)
    print("GRAND TOTAL OF INCREASES: " + str(total))

main()    
