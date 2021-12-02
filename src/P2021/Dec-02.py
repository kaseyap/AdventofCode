def fileInput():
    file = open("resources/02-file.txt" , 'r')
    content = file.read()
    li = content.split("\n")
    return li

def coordination(li):
    depth = 0
    horizontal = 0
    for i, e in enumerate(li):
        course = e.split(" ")
        if course[0] == "forward":
            horizontal = horizontal + int(course[1])
        elif course[0] == "up":
            depth = depth - int(course[1])
        elif course[0] == "down":
            depth = depth + int(course[1])    
    return (horizontal*depth)

def coordination2(li):
    aim = 0
    depth = 0
    horizontal = 0
    for i, e in enumerate(li):
        course = e.split(" ")
        if course[0] == "forward":
            horizontal = horizontal + int(course[1])
            if aim != 0:
                depth = depth + (aim*int(course[1]))
        elif course[0] == "up":
            aim = aim - int(course[1])
        elif course[0] == "down":
            aim = aim + int(course[1])    
    return (depth*horizontal)    

def main():
    directions = fileInput()
    area = coordination2(directions)
    print("Answer: " + str(area))

main()