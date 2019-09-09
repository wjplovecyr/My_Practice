'''
File:小球游戏.py
Project:game
Author:王继鹏
File Created:2019/5/20
'''
import pygame,sys



pygame.init()
Size = width,height = 1000,600
speed = [0,3]
# g = 9.8
# 物理 v=gt

BLACK = 0,0,0
screen = pygame.display.set_mode(Size)
pygame.display.set_caption("壁球")
background = pygame.image.load("image/gamebackground.png")
ball = pygame.image.load("image/小球.png")
board1 = pygame.image.load("image/木板.png")
# biu1 = pygame.image.load("image/弹簧前.png")
# ball = pygame.transform.chop(ball1, (100, 100, 200, 200))
# 第一个参数指定要裁减的图像，第二个参数指定要保留的图像的区域。返回裁减后留下的图像。

# pygame.time.delay(1000)#等待1秒让mixer完成初始化
pygame.mixer.music.load("music/小球.mp3")
mback=pygame.mixer.Sound("music/背景音乐.wav")
mhuala = pygame.mixer.Sound("music/10756.wav")

# pygame.mixer.music.load(mback)
class Button(object):
    def __init__(self, upimage, downimage, position):
        self.imageUp = pygame.image.load(upimage).convert_alpha()
        self.imageDown = pygame.image.load(downimage).convert_alpha()
        self.imageUp = pygame.transform.scale(self.imageUp, (30, 30))
        self.imageDown = pygame.transform.scale(self.imageDown, (40, 40))
        self.position = position
        self.bate = None

    def isOver(self):
        point_x, point_y = pygame.mouse.get_pos()
        x, y = self.position
        w, h = self.imageUp.get_size()

        in_x = x - w / 2 < point_x < x + w / 2
        in_y = y - h / 2 < point_y < y + h / 2
        return in_x and in_y

    def render(self):
        w, h = self.imageUp.get_size()
        x, y = self.position

        if self.isOver():
            screen.blit(self.imageDown, (x - w / 2, y - h / 2))
            # 增加鼠标监听
            if event.type == pygame.MOUSEBUTTONDOWN:  # 获取点击鼠标事件
                if event.button == 1:  # 点击鼠标左键
                    self.bate = True
            if event.type == pygame.MOUSEBUTTONUP:  # 获取松开鼠标事件
                if event.button == 1:  # 松开鼠标左键
                    self.bate = False
            return self.bate
        else:
            screen.blit(self.imageUp, (x - w / 2, y - h / 2))

class obj(object):
    def __init__(self, upimage, position):
        self.imageUp = pygame.image.load(upimage).convert_alpha()
        # self.imageUp = pygame.transform.scale(self.imageUp, (30, 30))
        self.position = position
        self.moving = None

    def isOver(self):
        point_x, point_y = pygame.mouse.get_pos()
        x, y = self.position
        w, h = self.imageUp.get_size()

        in_x = x - w / 2 < point_x < x + w / 2
        in_y = y - h / 2 < point_y < y + h / 2
        return in_x and in_y

    def render(self):
        w, h = self.imageUp.get_size()


        if self.isOver():
            # screen.blit(self.imageDown, (x - w / 2, y - h / 2))
        # else:
            # 增加鼠标监听
            if event.type == pygame.MOUSEBUTTONDOWN:  # 获取点击鼠标事件
                if event.button == 1:  # 点击鼠标左键
                    self.moving = True
            if event.type == pygame.MOUSEBUTTONUP:  # 获取松开鼠标事件
                if event.button == 1:  # 松开鼠标左键
                    self.moving = False
            if self.moving:
                self.position = pygame.mouse.get_pos()  # 更新小球位置为鼠标当前位置
        x, y = self.position
        ss = screen.blit(self.imageUp, (x - w / 2, y - h / 2))
        return ss



start1 = Button("image/开始.png","image/开始1.png",(400,20))
end = Button("image/结束.png","image/结束1.png",(450,20))
re = Button("image/重新开始.png","image/重新开始1.png",(500,20))

tan1 = obj("image/弹簧前.png",(400,100))
biubiu1 = obj("image/弹簧后.png",(300,100))
biu1 = obj("image/弹簧前.png",(200,100))
board1 = obj("image/木板.png",(600,100))
bboard1 =   obj("image/木板.png",(600,150))

# board = pygame.Rect(500,300,291,15)
ballrect = ball.get_rect()



fps = 300   #每秒运行300帧
fclock = pygame.time.Clock()
moving = False
mback.play()
test =  False
while True:

    screen.blit(background, (0, 0)) #添加背景
    if start1.render():
        test=start1.render()
    if test:     #开始
        ballrect = ballrect.move(speed[0], speed[1])  # 设置小球移动

    if end.render():        #结束
        sys.exit()
    # if re.render():         #重新
    #     break
    biubiu = biubiu1.render()
    biu = biu1.render()
    board = board1.render()
    tan = tan1.render()
    bboard = bboard1.render()
    # screen.blit(start, (0, 200))
    start = pygame.draw.lines(screen, BLACK, True, ((0, 180), (200, 300), (200, 330), (0, 330)), 3)     #画出起始台
    # screen.blit(biu1, biu)      #添加弹簧
    # screen.blit(board1,board)   #添加木板
    # biu.center = position       #弹簧位置

    # board.center = (500,400)
    # biu = biu.set(200,0)
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            sys.exit()


    # screen.blit(biu1, position)

    # if ballrect.left<0 or ballrect.right>width:
    #     speed[0] = -speed[0]
    if ballrect.colliderect(start) :    #小球与起始台有碰撞
        speed[1] = 2
        speed[0] = 3
    if ballrect.right>200:  #小球出了起始台
        speed[1] = speed[1]+1
    # if ballrect.bottom>330:
    #     speed[1] = 0
    if ballrect.right > width:  #小球到达终点，停止
        speed[0] = 0
        speed[1] = 0
        mback.stop()
        mhuala.play()

    # if (ballrect.bottom <biu.top) and (ballrect.right>biu.left ) :
    #     speed[1] = 0
    if ballrect.colliderect(biu):   #小球与弹簧之间碰撞效果
        pygame.mixer.music.play()
        speed[1] = -speed[1]
    if ballrect.colliderect(tan):   #小球与弹簧之间碰撞效果
        pygame.mixer.music.play()
        speed[1] = -speed[1]
    if ballrect.colliderect(biubiu):   #小球与弹簧之间碰撞效果
        pygame.mixer.music.play()
        speed[1] = -speed[1]-2

    if ballrect.colliderect(bboard):  # 小球在木板上弹弹弹
        if ballrect.top < bboard.bottom:
            pygame.mixer.music.play()
            speed[1] = -speed[1] + 1

    if ballrect.colliderect(board): #小球在木板上弹弹弹
        if ballrect.top<board.bottom:
            pygame.mixer.music.play()
            speed[1] = -speed[1]+1
    # if ballrect.top>600:    #小球掉落，结束
    #     sys.exit()
    # if ballrect.left> start.get_rect().right and (ballrect.bottom<0 or ballrect.top>height):
    #     speed[1] = -speed[1]
    # screen.fill(background)
    # and not ballrect.colliderect(board)
    # print(speed[0])
    if ballrect.top>600:    #重复创建小球
        ball = pygame.image.load("image/小球.png")
        ballrect = ball.get_rect()
        screen.blit(ball, ballrect)  # 添加小球
        test = False
        speed = [0, 3]

    screen.blit(ball,ballrect)  #添加小球
    pygame.display.update()     #刷新屏幕
    fclock.tick(fps)            #屏幕刷新度
