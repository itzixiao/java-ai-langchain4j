# 🏥 智能客服系统 —— 子孝 AI

> **“子孝”** 是一个基于 LangChain4j 和 Spring Boot 构建的医疗领域 AI 客服助手，具备医疗咨询、挂号预约、取消挂号等功能。它集成了 RAG（检索增强生成）、MongoDB 聊天记录存储、多模型支持等特性。

---

## 🚀 项目简介

该项目是一个完整的 AI 医疗客服系统，包含以下核心功能：

- 💬 智能对话：使用 LangChain4j 集成 OpenAI / Ollama 大语言模型
- 📚 知识库检索：基于本地文档构建嵌入式向量数据库，实现 RAG 对话
- 🧾 挂号管理：支持预约、查询、取消挂号操作
- 🗣️ 多轮对话：支持独立会话 ID 的聊天记忆
- 📊 数据持久化：使用 MongoDB 存储聊天记录，MySQL 存储挂号信息

---

## 🧩 技术栈

| 技术 | 描述 |
|------|------|
| 🧠 LangChain4j | 支持多种 LLM（如 GPT、Ollama）与工具调用 |
| 🌱 Spring Boot | 快速构建微服务架构 |
| 🗃️ MongoDB | 存储聊天记录 |
| 🗄️ MySQL | 存储挂号数据 |
| ⚙️ MyBatis Plus | ORM 数据访问层 |
| 🖼️ Vue3 + Vite | 前端界面（位于 `ai-ui` 目录） |

---

## 📁 项目结构

```
java-ai-langchain4j/
├── src/
│   ├── main/
│   │   ├── java/                  # Java 源代码
│   │   ├──resources/              # 配置文件与模板
│   │   │   ├── application.yml    # Spring Boot 配置文件
│   └── test/                      # 单元测试
├── ai-ui/                         # 前端界面（Vue3）
│   ├── package.json               # Node.js 依赖配置
└── README.md                      # 当前文件

```


---

## 🛠️ 后端模块说明

### 🔧 核心组件

| 模块 | 功能 |
|------|------|
| `Assistant.java` | AI 对话接口定义 |
| `ZixiaoAgent.java` | 子孝智能客服接口，集成 RAG、工具调用 |
| `ZixiaoController.java` | REST API 控制器 |
| `ZixiaoAgentConfig.java` | 配置聊天记忆、内容检索器等 Bean |
| `MongoChatMemoryStore.java` | MongoDB 聊天记录存储实现 |
| `AppointmentTools.java` | 挂号相关工具类 |
| `CalculatorTools.java` | 计算工具类（示例） |

### 📁 配置文件

- `application.yml`：Spring Boot 主配置文件，含数据库连接、LLM 参数等
- `zixiao-prompt-template.txt`：子孝的系统提示词模板

---

## 📦 数据库配置

### MongoDB

```yaml
spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      username: root
      password: root
      database: chat_memory_db
```


### MySQL

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/itzixiao?characterEncoding=utf-8&useSSL=false
    username: root
    password: root
```


---

## 🤖 AI 模型配置

```yaml
langchain4j:
  open-ai:
    chat-model:
      api-key: demo
      model-name: gpt-4o-mini
      base-url: http://langchain4j.dev/demo/openai/v1
      log-requests: true
      log-responses: true
  ollama:
    chat-model:
      base-url: http://localhost:11434
      model-name: deepseek-r1:7b
      log-requests: true
      log-responses: true
```


---

## 📲 前端界面 (`ai-ui`)

> 使用 Vue3 + Vite 构建，提供用户友好的聊天界面。

### 📁 文件结构

```
ai-ui/
├── src/
│   ├── components/
│   │   └── ChatWindow.vue     # 聊天窗口组件
│   ├── App.vue                # 主页面
│   ├── main.js                # 入口文件
│   └── style.css              # 样式表
├── index.html                 # 首页
├── package.json               # Node.js 依赖配置
└── vite.config.js             # Vite 配置
```


---

## 🧪 单元测试

- ✅ `AIServiceTest.java` - 测试 AI 服务基本功能
- ✅ `RAGTest.java` - 测试文档加载与向量存储
- ✅ `AppointmentServiceTest.java` - 挂号服务测试
- ✅ `MongoCrudTest.java` - MongoDB CRUD 操作测试
- ✅ `ToolsTest.java` - 工具类测试

---

## 🧰 启动方式

### 后端启动

```bash
cd java-ai-langchain4j
mvn spring-boot:run
```


或使用 IDE 运行 `MainApplication.java`

### 前端启动

```bash
cd ai-ui
npm install
npm run dev
```


访问 `http://localhost:5173` 查看聊天界面

---

## 📝 示例对话

> **你**: 我想预约神经内科医生  
> **子孝**: 请问您的姓名、身份证号？您希望预约哪一天？上午还是下午？

> **你**: 张三，123456789012345678，2025-07-14 上午  
> **子孝**: 🟢 您好！张三，已为您预约神经内科 2025-07-14 上午的号源，请按时就诊。

---

## ❤️ 贡献指南

欢迎提交 PR 或 Issue 来帮助完善这个项目！

- Fork 本仓库
- 创建新分支 `feature/your-feature-name`
- 提交代码并推送
- 发起 Pull Request

---

## 📞 联系我们

如有任何问题，欢迎联系：

📧 Email: itzixiao.cn@gmail.com

---
