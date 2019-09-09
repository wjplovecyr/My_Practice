import bpy
bpy.ops.mesh.primitive_plane_add(radius=100,locaation=(0,0,0))  #创建平面
bpy.ops.rigidbody.object_add()
bpy.context.object.rigid_body.type = 'PASSIVE'
for x in range(1,19):   #创建圆环
    bpy.ops.mesh.primitive_torus_add(location=(0,x*4.3,110),rotation=(0,1.5708*(x%2),0),major_radius=3.5,minor_radius = 0.5,abso_major_rad = 1.25,abso_minor_rad=0.75)
    bpy.ops.rigidbody.object_add()
    bpy.context.object.rigid_body.collision_shape = 'MESH'
    if x == 1:
        bpy.context.object.rigid_body.enabled = False
    for z in range(0,9):    #创建立方体
        bpy.ops.mesh.primitive_cube_add(radius=3,location=(x*6-60,2,2.8+z*6))
        bpy.ops.rigidbody.object_add()
        bpy.context.object.rigid_body.mass = 0.0001
