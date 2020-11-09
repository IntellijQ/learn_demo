# 数据结构
- **链表**
   + `双链表`
   + `约瑟夫问题`
***

- **队列**
   + `消息队列`
***

- **栈**
   + `逆波兰计算器`
***

- **递归**
   + `阶乘`
   + `斐波那契数列`
   + `八皇后问题`
***

- **排序算法**
   + 内部排序
     1. 插入排序
        * `直接插入排序(平均n^2-稳定-最差n^2):把n个元素看成一个有序表和一个无序表,通过构建有序表，对于未排序数据，在已排序表中从后向前扫描，找到相应位置并插入。`
        * `希尔排序(平均nlogn-不稳定-最差nlogn^2):把n个元素按下标进行增量m的分组，对每组使用直接插入排序；随着增量m的减少，每组包含的元素越来越多，当m=1时，算法终止`
     2. 选择排序
        * `简单选择排序(平均n^2-不稳定-最差n^2):首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置,然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕`
        * `堆排序`
     3. 交换排序
        * `冒泡排序(平均n^2-稳定-最差n^2):通过对待排序元素从前向后看，依次比较相邻元素的至，若发现逆序则交换，使值较大的元素逐渐从前向后移动`
        * `快速排序(平均nlogn-不稳定-最差n^2):该算法是对冒泡排序的一种改进，
                    基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
                    然后按照此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列`
     4. 归并排序`(平均nlogn-稳定-最差nlogn)`
        * `该算法采用经典的分治策略：分而治之，将问题分成小问题，然后递归求解`
     5. 基数排序`（平均nk-稳定-最差nk） k：桶的数量`
        * `该算法属于分配式排序 ，又称桶子法，它是通过键值的各个位的值，将要排序的元素分配值 预定的桶中`
   + 外部排序
***    


# spring

# mysql

完善中。。。
