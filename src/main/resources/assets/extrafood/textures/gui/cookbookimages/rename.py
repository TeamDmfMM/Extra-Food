import os

""" 
Renames the filenames within the same directory to be Unix friendly
(1) Changes spaces to hyphens
(2) Makes lowercase (not a Unix requirement, just looks better ;)

Usage:
python rename.py
"""

path =  os.getcwd()
filenames = os.listdir(path)

print("DOING")
for filename in filenames:
    print(filename)
    if(filename == "rename.py"):
        continue
    os.rename(filename, filename.replace(" ", "_").lower())
    #with open(filename, 'r+') as fileinput:
    #    liner = []
    #    for line in fileinput:
    #        liner.append(line.lower())
    #    fileinput.close()
    #    with open(filename, 'w') as fileinput:
    #        for line in liner:
    #            fileinput.write(line)
print("DONE")
