s = """
MQ基础-01.RabbitMQ课程介绍
08:48
MQ基础-02.初识MQ-同步调用
08:16
MQ基础-03.初识MQ-异步调用
10:29
MQ基础-04.初识MQ-技术选型
11:17
MQ基础-05.RabbitMQ-认识和安装
08:24
MQ基础-06.RabbitMQ-快速入门
08:54
MQ基础-07.RabbitMQ-数据隔离
07:46
MQ基础-08.Java客户端-快速入门
19:34
MQ基础-09.Java客户端-work模型
16:45
MQ基础-10.Java客户端-Fanout交换机
10:28
MQ基础-11.Java客户端-Direct交换机
08:30
MQ基础-12.Java客户端-Topic交换机
08:11
MQ基础-13.Java客户端-声明队列和交换机的方式一
16:54
MQ基础-14.Java客户端-声明队列和交换机的方式二
05:50
MQ基础-15.Java客户端-消息转换器
13:03
MQ基础-16.改造业务代码
11:34
MQ高级-01.今日课程介绍
04:31
MQ高级-02.生产者可靠性-生产者重连
07:09
MQ高级-03.生产者可靠性-生产者确认原理
05:36
MQ高级-04.生产者可靠性-生产者确认代码实现
28:04
MQ高级-05.MQ的可靠性-数据持久化
17:35
MQ高级-06.MQ的可靠性-LazyQueue
08:00
MQ高级-07.消费者可靠性-消费者确认
15:06
MQ高级-08.消费者可靠性-失败重试机制
21:54
MQ高级-09.消费者可靠性-业务幂等性
31:40
MQ高级-10.延迟消息-什么是延迟消息
07:35
MQ高级-11.延迟消息-死信交换机
17:50
MQ高级-12.延迟消息-延迟消息插件
13:11
MQ高级-13.延迟消息-取消超时订单的基本思路
11:11
MQ高级-14.延迟消息-发送延迟检测订单的消息
11:15
MQ高级-15.延迟消息-监听延迟消息
18:06"""


def f(s):
    lines = s.split("\n")
    time_str = []
    for line in lines:
        if ":" in line:
            time_str.append(line)
    times = []
    for t in time_str:
        arr = t.split(":")
        if len(arr) == 2:
            minutes, seconds = t.split(":")
            times.append(int(minutes) + int(seconds) / 60)
        else:
            hours, minutes, seconds = t.split(":")
            times.append(int(hours) * 60 + int(minutes) + int(seconds) / 60)
    episode = input("Enter the episode you are on: ")
    print(sum(times[: int(episode)]) / 60)


f(s)
