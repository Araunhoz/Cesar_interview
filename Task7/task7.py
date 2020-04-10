
# Developed: Paulo Henrique Araujo Munhoz  data: 2020/04/08

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def get_prev_node(self, pnode):
        current = self.head
        while current and current.next != pnode:
            current = current.next
        return current

    def insert_at_end(self, nnode):
        if self.head is None:
            self.head = nnode
        else:
            current = self.head
            while current.next is not None:
                current = current.next
            current.next = nnode

    def remove(self, node):
        prev_node = self.get_prev_node(node)
        if prev_node is None:
            self.head = self.head.next
        else:
            prev_node.next = node.next

    def display(self):
        current = self.head
        while current:
            print(current.data, end=' ')
            current = current.next


def remove_duplicates(llistd):
    current1 = llistd.head
    while current1:
        current2 = current1.next
        data = current1.data
        while current2:
            aux = current2
            current2 = current2.next
            if aux.data == data:
                llistd.remove(aux)
        current1 = current1.next


def find_intersection(list1, list2):
    if list1.head is None or list2.head is None:
        return LinkedList()

    intersection = LinkedList()
    current1 = list1.head
    while current1:
        current2 = list2.head
        data = current1.data
        while current2:
            if current2.data == data:
                node = Node(data)
                intersection.insert_at_end(node)
                break
            current2 = current2.next
        current1 = current1.next
    remove_duplicates(intersection)

    return intersection


aux_list1 = LinkedList()
aux_list2 = LinkedList()
data_list1 = input('Please enter the elements in the first linked list: ').split()
data_list2 = input('Please enter the elements in the second linked list: ').split()
for data in data_list1:
    node = Node(int(data))
    aux_list1.insert_at_end(node)

for data in data_list2:
    node = Node(int(data))
    aux_list2.insert_at_end(node)

intersection = find_intersection(aux_list1, aux_list2)

print('Intersection: ')
intersection.display()

