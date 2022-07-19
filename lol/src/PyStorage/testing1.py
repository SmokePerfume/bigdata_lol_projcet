import sys



def sum(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10):
    result = int(v1) + int(v2)+ int(v3) + int(v4)+ int(v5) + int(v6)+ int(v7) + int(v8)+ int(v9) + int(v10)
    print(result)


def main(argv):
    sum(argv[1], argv[2],argv[3],argv[4],argv[5],argv[6],argv[7],argv[8],argv[9],argv[10])

if __name__ == "__main__":
    main(sys.argv)