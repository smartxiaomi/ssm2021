let app = new Vue({
    el: "#app",
    data() {
        //自定义表单验证规则，验证工资项
        let checkSalary = (rule, value, callback) => {
            if (isNaN(value)) {
                return callback(new Error('请输入数字值'));
            }
            if (value < 0) {
                return callback(new Error('必须大于0'));
            }
            //验证通过
            return callback();
        };
        return {
            //封装整个页面数据
            pageBean: {},
            //封装查询条件
            param: {
                name: "",
                sex: "",   //查询条件
                departId: [],  //部门主键，可以查询多个部门
                birthday: [],  //生日范围，注：这里是一个数组，到了服务器端是一个ArrayList集合
                current: 1,  //当前页
                size: 5   //每页大小
            },
            //所有的部门集合
            departs: [],
            //前面的复选框
            employeeIds: [],
            //对话框默认不可见
            dialogFormVisible: false,
            //表单项的内容
            form: {
                name: '',
                sex: '男',
                salary: '',
                birthday: '',
                departId: ''
            },

            //校验规则
            rules: {
                //员工姓名
                name: [
                    {required: true, message: '员工姓名不能为空', trigger: 'blur'},
                    {min: 2, max: 10, message: '长度在2到10个字符', trigger: 'blur'}
                ],
                sex: [
                    {required: true, message: '请选择性别', trigger: 'blur'}
                ],
                salary: [
                    {required: true, message: '请输入工资', trigger: 'blur'},
                    //使用自定义规则
                    {validator: checkSalary, trigger: 'blur'}
                ],
                birthday: [
                    {required: true, message: '请选择日期', trigger: 'blur'}
                ],
                departId: [
                    {required: true, message: '选择一个部门', trigger: 'blur'}
                ]
            }
        }
    },
    methods: {
        //改变页大小
        handleSizeChange(val) {
            this.param.size = val;
            //查询所有页面
            this.findAllEmployees();
        },
        //改变当前页
        handleCurrentChange(val) {
            this.param.current = val;
            //查询所有页面
            this.findAllEmployees();
        },
        //编辑按钮：索引号，这一行的数据对象
        handleEdit(index, row) {
            //打开编辑窗口
            this.dialogFormVisible = true;
            //显示数据在窗口中，直接赋值会导致表格中显示的数据也发生变化
            Object.assign(this.form, row);   //复制属性
        },
        //删除按钮
        handleDelete(index, row) {
            this.$confirm('确定要删除员工 ' + row.name + ' 吗?', '删除操作', {
                type: 'warning'
            }).then(() => {
                //后台访问服务器删除
                axios.get("employee/delete?id=" + row.id).then((resp) => {
                    //在控制台输出结果
                    console.log(resp.data);

                    if (resp.data > 0) {
                        this.$message.success("成功删除员工" + row.name);
                        //重新加载员工
                        this.findAllEmployees();
                    } else {
                        this.$message.error("删除员工" + row.name + "失败");
                    }
                });
            }).catch(() => {
            });
        },
        //前面的复选框发生变化
        handleSelectionChange(val) {
            //先清空
            this.employeeIds = [];
            //获取的是整个行的数组
            for (let row of val) {
                //只得到每行的id，添加到集合中
                this.employeeIds.push(row.id);
            }
        },
        //显示编辑的窗口
        showAddDialog() {
            //设置为可见
            this.dialogFormVisible = true;
            //将form清空
            this.form = {
                name: '',
                sex: '男',
                salary: '',
                birthday: '',
                departId: ''
            }
        },
        //添加员工的取消按钮
        employeeCancel() {
            this.dialogFormVisible = false;
            //表单内容重置，清除校验规则
            this.$refs.employeeForm.resetFields();
        },
        //添加员工的确定按钮
        saveEmployee() {
            //提交前再次验证, $refs引用表单上ref属性中名字，调用validate方法验证整个表单
            this.$refs["employeeForm"].validate((valid) => {
                //验证通过
                if (valid) {
                    //如果有id值则是更新，没有就是添加
                    console.log(this.form);
                    //更新
                    if (this.form.id) {
                        axios.post("employee/update", this.form).then((resp) => {
                            let row = resp.data;
                            //成功以后才查询员工
                            if (row > 0) {
                                this.$message.success('成功更新员工 ' + this.form.name + ' 的信息');
                                //关闭信息框
                                this.dialogFormVisible = false;
                                //表单内容重置，清除校验规则
                                this.$refs.employeeForm.resetFields();
                                //重新加载所有员工
                                this.findAllEmployees();
                            } else {
                                this.$message.error('更新员工 ' + this.form.name + ' 失败');
                            }
                        });
                    }
                    //添加
                    else {
                        axios.post("employee/save", this.form).then((resp) => {
                            let row = resp.data;
                            //添加成功
                            if (row > 0) {
                                this.$message.success('成功添加员工 ' + this.form.name + ' 的信息');
                                //关闭信息框
                                this.dialogFormVisible = false;
                                //表单内容重置，清除校验规则
                                this.$refs.employeeForm.resetFields();
                                //重新加载所有员工
                                this.findAllEmployees();
                            } else {
                                this.$message.error('添加员工 ' + this.form.name + ' 失败');
                            }
                        });
                    }
                }
            });

        },
        //第一列的行号
        indexMethod(index) {
            return (this.param.current - 1) * this.param.size + 1 + index;
        },
        //格式化工资列
        formatSalary(row, column, cellValue, index) {
            return "￥" + cellValue;
        },
        //清除查询条件按钮
        clearCondition() {
            this.param.name = "";
            this.param.sex = "";
            this.param.departId = [];
            this.param.birthday = [];
            //无条件查询
            this.findAllEmployees();
        },
        //所有的查询条件发生变化调用这个方法，因为绑定了condition中的属性
        changeCondition() {
            //先跳到第1页，以免出现显示不了的bug
            this.param.current = 1;
            //再查询
            this.findAllEmployees();
        },
        //分页查询所有联系人
        findAllEmployees() {
            axios.post("employee/findPage", this.param).then(resp => {
                //获取PageBean对象
                this.pageBean = resp.data;
            });
        },
        //查询所有的部门
        findAllDeparts() {
            axios.post("depart/findAll").then(resp => {
                //得到所有的部门集合
                this.departs = resp.data;
            });
        },
        //删除多个员工
        deleteEmployees() {
            let num = this.employeeIds.length;
            //判断是否有选中
            if (num == 0) {
                this.$alert('请至少选中一个要删除的员工', '批量删除', {
                    type: 'info'
                });
            } else {
                this.$confirm("确定要删除这" + num + "个员工吗?", "批量删除", {
                    type: 'warning'
                }).then(() => { //点确定按钮
                    axios.post("employee/deleteEmployees", this.employeeIds).then((resp) => {
                        let row = resp.data;
                        if (row > 0) {
                            this.$message.success("成功删除" + row + "个员工");
                            //重新加载
                            this.findAllEmployees();
                        } else {
                            this.$message.error("删除员工失败");
                        }
                    });
                });
            }
        }
    },
    //创建的方法
    created() {
        //查询所有员工
        this.findAllEmployees();
        //查询所有的部门，给下拉列表用
        this.findAllDeparts();
    }
});